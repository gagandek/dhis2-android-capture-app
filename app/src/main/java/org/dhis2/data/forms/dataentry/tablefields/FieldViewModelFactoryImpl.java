package org.dhis2.data.forms.dataentry.tablefields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.dhis2.data.forms.dataentry.tablefields.age.AgeViewModel;
import org.dhis2.data.forms.dataentry.tablefields.coordinate.CoordinateViewModel;
import org.dhis2.data.forms.dataentry.tablefields.datetime.DateTimeViewModel;
import org.dhis2.data.forms.dataentry.tablefields.edittext.EditTextViewModel;
import org.dhis2.data.forms.dataentry.tablefields.image.ImageViewModel;
import org.dhis2.data.forms.dataentry.tablefields.orgUnit.OrgUnitViewModel;
import org.dhis2.data.forms.dataentry.tablefields.radiobutton.RadioButtonViewModel;
import org.dhis2.data.forms.dataentry.tablefields.spinner.SpinnerViewModel;
import org.dhis2.data.forms.dataentry.tablefields.unsupported.UnsupportedViewModel;
import org.hisp.dhis.android.core.common.ValueType;
import org.hisp.dhis.android.core.program.ProgramStageSectionRenderingType;

import java.util.List;

import static android.text.TextUtils.isEmpty;
import static org.dhis2.utils.Preconditions.isNull;

public final class FieldViewModelFactoryImpl implements FieldViewModelFactory {

    @NonNull
    private final String hintEnterText;

    @NonNull
    private final String hintEnterLongText;

    @NonNull
    private final String hintEnterNumber;

    @NonNull
    private final String hintEnterInteger;

    @NonNull
    private final String hintEnterIntegerPositive;

    @NonNull
    private final String hintEnterIntegerNegative;

    @NonNull
    private final String hintEnterIntegerZeroOrPositive;

    @NonNull
    private final String hintFilterOptions;

    @NonNull
    private final String hintChooseDate;

    public FieldViewModelFactoryImpl(@NonNull String hintEnterText, @NonNull String hintEnterLongText,
                                     @NonNull String hintEnterNumber, @NonNull String hintEnterInteger,
                                     @NonNull String hintEnterIntegerPositive, @NonNull String hintEnterIntegerNegative,
                                     @NonNull String hintEnterIntegerZeroOrPositive, @NonNull String filterOptions,
                                     @NonNull String hintChooseDate) {
        this.hintEnterText = hintEnterText;
        this.hintEnterLongText = hintEnterLongText;
        this.hintEnterNumber = hintEnterNumber;
        this.hintEnterInteger = hintEnterInteger;
        this.hintEnterIntegerPositive = hintEnterIntegerPositive;
        this.hintEnterIntegerNegative = hintEnterIntegerNegative;
        this.hintEnterIntegerZeroOrPositive = hintEnterIntegerZeroOrPositive;
        this.hintFilterOptions = filterOptions;
        this.hintChooseDate = hintChooseDate;
    }

    @NonNull
    @Override
    @SuppressWarnings({
            "PMD.CyclomaticComplexity",
            "PMD.StdCyclomaticComplexity"
    })
    public FieldViewModel create(@NonNull String id, @NonNull String label, @NonNull ValueType type,
                                 @NonNull Boolean mandatory, @Nullable String optionSet, @Nullable String value,
                                 @Nullable String section, @Nullable Boolean allowFutureDates, @NonNull Boolean editable, @Nullable ProgramStageSectionRenderingType renderingType,
                                 @Nullable String description, @Nullable String dataElement, @Nullable List<String> listCategoryOption, @Nullable String storeBy,
                                 @Nullable int row, @Nullable int column) {
        isNull(type, "type must be supplied");

        if (!isEmpty(optionSet)) {
            if (renderingType == null || renderingType == ProgramStageSectionRenderingType.LISTING)
                return SpinnerViewModel.create(id, label, hintFilterOptions, mandatory, optionSet, value, section, editable, description,dataElement,listCategoryOption,storeBy, row, column);
            else
                return ImageViewModel.create(id, label, optionSet, value, section, editable, mandatory, description,dataElement,listCategoryOption,storeBy, row, column); //transforms option set into image option selector
        }

        switch (type) {
            case AGE:
                return AgeViewModel.create(id, label, mandatory, value, section, editable, description,dataElement,listCategoryOption,storeBy, row, column);
            case TEXT:
            case EMAIL:
            case LETTER:
            case NUMBER:
            case INTEGER:
            case LONG_TEXT:
            case PERCENTAGE:
            case PHONE_NUMBER:
            case INTEGER_NEGATIVE:
            case INTEGER_POSITIVE:
            case INTEGER_ZERO_OR_POSITIVE:
            case UNIT_INTERVAL:
            case URL:
                return EditTextViewModel.create(id, label, mandatory, value, hintEnterText, 1, type, section, editable, description, dataElement, listCategoryOption, storeBy, row, column);
            case TIME:
            case DATE:
            case DATETIME:
                return DateTimeViewModel.create(id, label, mandatory, type, value, section, allowFutureDates, editable, description,dataElement,listCategoryOption,storeBy, row, column);
            case COORDINATE:
                return CoordinateViewModel.create(id, label, mandatory, value, section, editable, description,dataElement,listCategoryOption,storeBy, row, column);
            case BOOLEAN:
            case TRUE_ONLY:
                return RadioButtonViewModel.fromRawValue(id, label, type, mandatory, value, section, editable, description,dataElement,listCategoryOption,storeBy, row, column);
            case ORGANISATION_UNIT:
                return OrgUnitViewModel.create(id, label, mandatory, value, section, editable, description,dataElement,listCategoryOption,storeBy, row, column);
            case FILE_RESOURCE:
            case IMAGE:
            case TRACKER_ASSOCIATE:
            case USERNAME:
                return UnsupportedViewModel.create(id, label, mandatory, value, section, editable, description,dataElement,listCategoryOption,storeBy, row, column);
            default:
                return EditTextViewModel.create(id, label, mandatory, value, hintEnterText, 1, type, section, editable, description, dataElement, listCategoryOption, storeBy, row, column);
        }
    }
}